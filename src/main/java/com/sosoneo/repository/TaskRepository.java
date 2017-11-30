package com.sosoneo.repository;

import com.sosoneo.model.TTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sosoneo on 2017/11/24.
 */
@Repository
public interface TaskRepository extends JpaRepository<TTaskEntity, Integer> {
    @Modifying
    @Transactional
    @Query("update TTaskEntity task set " +
            "task.title=:title, " +
            "task.info=:info," +
            "task.linkUrl=:linkUrl," +
            "task.iconUrl=:iconUrl," +
            "task.bannerUrl=:bannerUrl,"+
            "task.bannerTitle=:bannerTitle,"+
            "task.bannerLinkUrl=:bannerLinkUrl "+
            "where task.id=:id")
    public void updateTask(@Param("title") String title, @Param("info") String info,
                           @Param("linkUrl") String linkUrl, @Param("iconUrl") String iconUrl,
                           @Param("bannerUrl") String bannerUrl, @Param("bannerTitle") String bannerTitle,
                           @Param("bannerLinkUrl") String bannerLinkUrl,
                           @Param("id") Integer id);
}
