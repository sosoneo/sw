package com.sosoneo.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by sosoneo on 2017/11/24.
 */
@Entity
@Table(name = "t_task", schema = "db_sw", catalog = "")
public class TTaskEntity {
    private int id;
    @NotEmpty(message = "任务名称不能为空")
    private String title;
    @NotEmpty(message = "任务详情不能为空")
    private String info;
    @NotEmpty(message = "任务头像链接不能为空")
    private String iconUrl;
    private String bannerUrl;
    private String bannerTitle;
    private String bannerLinkUrl;
    @NotEmpty(message = "任务链接不能为空")
    private String linkUrl;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "info", nullable = true, length = 100)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "icon_url", nullable = false, length = 100)
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Basic
    @Column(name = "banner_url", nullable = true, length = 100)
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @Basic
    @Column(name = "banner_title", nullable = true, length = 100)
    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    @Basic
    @Column(name = "banner_link_url", nullable = true, length = 100)
    public String getBannerLinkUrl() {
        return bannerLinkUrl;
    }

    public void setBannerLinkUrl(String bannerLinkUrl) {
        this.bannerLinkUrl = bannerLinkUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTaskEntity that = (TTaskEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (iconUrl != null ? !iconUrl.equals(that.iconUrl) : that.iconUrl != null) return false;
        if (bannerUrl != null ? !bannerUrl.equals(that.bannerUrl) : that.bannerUrl != null) return false;
        if (bannerTitle != null ? !bannerTitle.equals(that.bannerTitle) : that.bannerTitle != null) return false;
        if (bannerLinkUrl != null ? !bannerLinkUrl.equals(that.bannerLinkUrl) : that.bannerLinkUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (bannerUrl != null ? bannerUrl.hashCode() : 0);
        result = 31 * result + (bannerTitle != null ? bannerTitle.hashCode() : 0);
        result = 31 * result + (bannerLinkUrl != null ? bannerLinkUrl.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "link_url", nullable = false, length = 100)
    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
