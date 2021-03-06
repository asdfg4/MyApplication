package notice.liangxq.com.mymvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 项目名：xiaoshixun
 * 包名：  notice.liangxq.com.mymvp.base
 * 文件名：SimpleActivity
 * 创建者：liangxq
 * 创建时间：2018/12/12  17:05
 * 描述：TODO
 */
public abstract class SimpleActivity extends AppCompatActivity {


    private Unbinder bind;
    private Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayoutId());
        bind = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
        initEventAndData();
    }

    //设置ToolBar标题
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        //设置支持Actionbar
        setSupportActionBar(toolbar);
        // 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标，对应id为 android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //设置返回键监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // onBackPressed();//退出
                finish();
            }
        });
    }
    //初始化事件和数据
    protected abstract void initEventAndData();

    //布局完成后的方法
    public void onViewCreated() {

    }

    //设置布局Id
    protected abstract int createLayoutId();
}
