package by.htp.main.bean;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "news")
public class News implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_news")
	private Integer newsId;
	
	@NotNull(message = "Empty field! Please enter")
	@Pattern(regexp = "^[a-zA-Z0-9- ]{1,25}$", message = "Regex error! Check Title")
	@Column(name = "title")
	private String title;

	@NotNull (message = "Empty field! Please enter")
	@Pattern(regexp = "^[a-zA-Z0-9- ]{1,80}$", message = "Regex error! Check Brief")
	@Column(name = "brief")
	private String brief;

	@NotNull (message = "Empty field! Please enter")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-_\\. ]{1,200}$", message = "Regex error! Check Content")
	@Column(name = "content")
	private String content;

	
	@NotNull (message = "Empty field! Please enter")
	@Pattern(regexp = "(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2}):(\\d{2})"
	, message = "Regex error! Check Date")
	@Column(name = "news_create_date")
	private String newsDate;


	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,	CascadeType.REFRESH })
	@JoinColumn(name = "id_user")
	private User user;

	public News() {
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public int hashCode() {
		return Objects.hash(brief, content, newsId, newsDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		News other = (News) obj;
		return Objects.equals(brief, other.brief) && Objects.equals(content, other.content)
				&& Objects.equals(newsId, other.newsId) && Objects.equals(newsDate, other.newsDate)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", title=" + title + ", briefNews=" + brief + ", content=" + content
				+ ", newsDate=" + newsDate + "]";
	}

}
