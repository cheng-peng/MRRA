package com.cxp.module_main.ui.test.activity.room;

import android.arch.persistence.room.Room;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.cxp.lib_common.base.BaseActivity;
import com.cxp.module_main.R;
import com.cxp.module_main.ui.test.activity.room.db.BookDao;
import com.cxp.module_main.ui.test.activity.room.db.MyDatabase;
import com.cxp.module_main.ui.test.activity.room.db.UserDao;
import com.cxp.module_main.ui.test.activity.room.entity.Book;
import com.cxp.module_main.ui.test.activity.room.entity.User;
import com.cxp.module_main.ui.test.activity.room.entity.UserAndBook;

import java.util.ArrayList;
import java.util.List;

/**
 * 文 件 名: RoomActivity
 * 创 建 人: CXP
 * 创建日期: 2018-05-28 17:11
 * 描    述: 数据库基本操作
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class RoomActivity extends BaseActivity {

    private TextView tv;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            tv.setText(msg.obj.toString());
            return true;
        }
    });

    @Override
    protected void initView() {
        setContentView(R.layout.activity_room);

        tv = findViewById(R.id.room_tv);
    }


    //单击事件
    public void clickLis(View view) {

        MyDatabase mUserDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "room.db").build();
        final UserDao dao = mUserDatabase.getUserDao();
        final BookDao bookDao = mUserDatabase.getBookDao();
        if (view.getId() == R.id.room_bt1) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //增加数据
                    addData(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt2) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //查询数据
                    queryData(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt3) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //修改数据
                    updateData(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt4) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //删除数据
                    deleteData(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt5) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //批量增加数据
                    addDataAll(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt6) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //批量修改数据
                    updateDataAll(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt7) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //批量删除数据
                    deleteDataAll(dao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt8) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //增加Book数据
                    addBook(bookDao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt9) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //查询Book数据
                    queryBook(bookDao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt10) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //多表查询
                    queryBookAndUser(bookDao);
                }
            }).start();
        } else if (view.getId() == R.id.room_bt11) {
            //必须要在子线程里执行数据库操作
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //条件查询
                    queryUserInfo(dao);
                }
            }).start();
        }
    }


    /**
     * 增加数据
     */
    private void addData(UserDao dao) {
        User user = new User();
        user.setName("CXP");
        user.setAge(18);
        user.setUpdateTime(System.currentTimeMillis());
        user.setSex(1);
        dao.insertUser(user);
    }

    /**
     * 批量增加数据
     */
    private void addDataAll(UserDao dao) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("CXP");
            user.setAge(i);
            user.setUpdateTime(System.currentTimeMillis());
            user.setSex(i);
            list.add(user);
        }
        dao.insertUserAll(list);
    }


    /**
     * 条件查询数据
     */
    private void queryUserInfo(UserDao dao) {
        User user = dao.queryUser(10);
        Message message = new Message();
        message.obj = user.getName() + "，" + user.getAge() + "\n";
        handler.sendMessage(message);
    }

    /**
     * 查询数据
     */
    private void queryData(UserDao dao) {
        List<User> list = dao.queryUserAll();
        Message message = new Message();
        StringBuffer sbStr = new StringBuffer();
        if (list != null && list.size() != 0) {
            for (User user : list) {
                sbStr.append(user.getName() + "，" + user.getAge() + "\n");
            }
        }
        message.obj = sbStr.toString();
        handler.sendMessage(message);
    }

    /**
     * 修改数据
     */
    private void updateData(UserDao dao) {
        User user = new User();
        user.setId(1);
        user.setName("CXP1");
        user.setAge(10);
        user.setUpdateTime(System.currentTimeMillis());
        dao.updateUser(user);
    }

    /**
     * 批量修改数据
     */
    private void updateDataAll(UserDao dao) {
        List<User> userList = dao.queryUserAll();
        for (User user : userList) {
            user.setName("CXP1");
            user.setAge(12);
            user.setUpdateTime(System.currentTimeMillis());
        }
        dao.updateUserAll(userList);
    }

    /**
     * 删除数据
     */
    private void deleteData(UserDao dao) {
        User user = new User();
        user.setId(1);
        dao.deleteUser(user);
    }

    /**
     * 批量删除数据
     */
    private void deleteDataAll(UserDao dao) {
        List<User> userList = dao.queryUserAll();
        dao.deleteUserAll(userList);
    }

    /**
     * 增加Book数据
     */
    private void addBook(BookDao dao) {
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setBookName("小说");
            book.setBookType("玄幻");
            book.setBookId(i + 1);
            dao.insertBook(book);
        }
    }

    /**
     * 查询Book数据
     */
    private void queryBook(BookDao dao) {
        List<Book> list = dao.queryBookAll();
        Message message = new Message();
        StringBuffer sbStr = new StringBuffer();
        if (list != null && list.size() != 0) {
            for (Book book : list) {
                sbStr.append(book.getBookName() + "，" + book.getBookType() + "\n");
            }
        }
        message.obj = sbStr.toString();
        handler.sendMessage(message);
    }

    /**
     * 多表查询
     */
    private void queryBookAndUser(BookDao dao) {
        List<UserAndBook> list = dao.queryBookAndUser();
        Message message = new Message();
        StringBuffer sbStr = new StringBuffer();
        if (list != null && list.size() != 0) {
            for (UserAndBook ub : list) {
                sbStr.append(ub.getName() + "，" + ub.getAge() + "，" + ub.getBookName() + "，" + ub.getBookType() + "\n");
            }
        }
        message.obj = sbStr.toString();
        handler.sendMessage(message);
    }

}
