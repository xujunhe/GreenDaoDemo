package xin.lsxjh.greendaodemo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import java.util.Date;

/**
 * Created by olyls on 2017/8/16.
 */

@Entity(indexes = {
        @Index(value = "text, date DESC", unique = true)
})
public class Note {
    @Id
    private Long id;
    @NotNull
    private String text;
    private String comment;
    private Date date;
    private String update;

@Generated(hash = 2002913252)
public Note(Long id, @NotNull String text, String comment, Date date,
        String update) {
    this.id = id;
    this.text = text;
    this.comment = comment;
    this.date = date;
    this.update = update;
}
@Generated(hash = 1272611929)
public Note() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getText() {
    return this.text;
}
public void setText(String text) {
    this.text = text;
}
public String getComment() {
    return this.comment;
}
public void setComment(String comment) {
    this.comment = comment;
}
public Date getDate() {
    return this.date;
}
public void setDate(java.util.Date date) {
    this.date = date;
}

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", update='" + update + '\'' +
                '}';
    }

    public String getUpdate() {
    return this.update;
}
public void setUpdate(String update) {
    this.update = update;
}
}
