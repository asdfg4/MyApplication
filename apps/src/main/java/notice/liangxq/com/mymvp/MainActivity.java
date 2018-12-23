package notice.liangxq.com.mymvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import notice.liangxq.com.mymvp.base.SimpleActivity;
import notice.liangxq.com.mymvp.fragment.guanyu.guany;
import notice.liangxq.com.mymvp.fragment.zhihu.ZhihuMainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            toolBar.setTitle("知乎日报");
            fragmentTransaction.replace(R.id.fl_content, new ZhihuMainFragment());
        } else if (id == R.id.nav_gallery) {
            toolBar.setTitle("知乎日报");
        } else if (id == R.id.nav_slideshow) {
            toolBar.setTitle("知乎日报");
        } else if (id == R.id.nav_manage) {
            toolBar.setTitle("知乎日报");
        } else if (id == R.id.nav_share) {
            toolBar.setTitle("知乎日报");
        } else if (id == R.id.nav_send) {
            toolBar.setTitle("知乎日报");
        }else if (id==R.id.as){
            toolBar.setTitle("知乎日报");
        }else  if (id==R.id.nav_sendA){
            toolBar.setTitle("关于");
            fragmentTransaction.replace(R.id.fl_content, new guany());
        }
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
