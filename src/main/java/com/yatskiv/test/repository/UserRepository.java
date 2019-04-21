package com.yatskiv.test.repository;

import com.yatskiv.test.entity.User;
import com.yatskiv.test.util.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeIsGreaterThan(Integer age);

    @Query(value = "SELECT DISTINCT NAME FROM USER OUTER LEFT JOIN USER_ARTICLES on ID = USER_ARTICLES.USER_ID GROUP BY ID HAVING COUNT (*) > :articlesSize", nativeQuery = true)
    Set<String> findUniqueNamesWhereArticlesIsGreaterThan(@Param("articlesSize") Integer count);

    @Query(value = "SELECT * FROM USER U JOIN USER_ARTICLES ua ON U.ID = ua.USER_ID JOIN ARTICLE A ON ua.ARTICLES_ID = A.ID WHERE LOWER(A.COLOR) = LOWER(:#{#color?.toString()})", nativeQuery = true)
    Set<User> findAllByArticlesContainsCColor(@Param("color") Color color);
}
