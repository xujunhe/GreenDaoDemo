package xin.lsxjh.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Date;
import java.util.List;

import xin.lsxjh.greendao.gen.DaoSession;
import xin.lsxjh.greendao.gen.NoteDao;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private void assignViews() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
    }


    NoteDao noteDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        noteDao = daoSession.getNoteDao();
        //daoSession.clear();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note.setComment("回复内容");
                note.setDate(new Date());
                note.setText("我是内容");
                noteDao.insert(note);


                Toast.makeText(getApplicationContext(),"添加成功！"+note.getId(),Toast.LENGTH_LONG).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note.setComment("回复内容修改");
                note.setDate(new Date());
                note.setText("我是内容修改");
                note.setId(2L);
                note.setUpdate("我添加了字段 update");
                noteDao.update(note);
                Toast.makeText(getApplicationContext(),"修改成功！"+note.getId(),Toast.LENGTH_LONG).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Note> list = noteDao.queryBuilder().where(NoteDao.Properties.Id.ge(5)).list();
                if (null==list)return;
                for (Note note :list)
                {

                    Log.d(TAG, "onClick: "+note.toString());
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteDao.deleteByKey(1L);
                Toast.makeText(getApplicationContext(),"删除成功！",Toast.LENGTH_LONG).show();

            }
        });

    }
}
