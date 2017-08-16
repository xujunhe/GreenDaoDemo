package xin.lsxjh.greendaodemo;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import xin.lsxjh.greendao.gen.DaoMaster;
import xin.lsxjh.greendao.gen.DaoSession;

/**
 * Created by olyls on 2017/8/16.
 */

public class App extends Application{
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db =  helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
