package project.memories.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import project.memories.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Aggregation(pipeline = {"{$lookup: {\n" +
            "                from: 'mem_post_likes',\n" +
            "                localField: 'id',\n" +
            "                foreignField: 'post_id',\n" +
            "                as: 'postLikes'\n" +
            "            }}", "{$lookup: {\n" +
            "                from: 'mem_post_comments',\n" +
            "                localField: 'id',\n" +
            "                foreignField: 'post_id',\n" +
            "                as: 'postComments'\n" +
            "            }}", "{$project: {\n" +
            "                _class: 1,\n" +
            "                author: 1,\n" +
            "                description: 1,\n" +
            "                images: 1,\n" +
            "                liked: {\n" +
            "                   $eq: [{\n" +
            "                       $size: {\n" +
            "                           $filter: {\n" +
            "                               input: '$postLikes',\n" +
            "                               as: 'postLike',\n" +
            "                               cond: {$eq: ['$$postLike.author.$id', ?0]}\n" +
            "                           }\n" +
            "                       },\n" +
            "                   }, 1]\n" +
            "                },\n" +
            "                countOfLikes: {$size: '$postLikes'}\n" +
            "                countOfComments: {$size: '$postComments'}\n" +
            "            }}"})
    List<Post> findAllPosts(String memoriesUserId, Pageable pageable);
}
