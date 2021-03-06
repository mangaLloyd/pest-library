package ph.sarai.pestlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DbananaActivity extends AppCompatActivity implements ItemAllAdapter.ClickListener{

    private RecyclerView bananaRecycler;
    private ItemAllAdapter bananaAdapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbanana);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerFragment drawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_drawer);
        drawerFragment.setUp(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        bananaRecycler = (RecyclerView) findViewById(R.id.pest_items_all);
        bananaRecycler.setHasFixedSize(true);
        LinearLayoutManager bananaLinearLayout = new LinearLayoutManager(this);
        bananaLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        bananaRecycler.setLayoutManager(bananaLinearLayout);
        bananaAdapter = new ItemAllAdapter(this, new ItemData(this).getAllDbananaItemData(), 2);
        bananaAdapter.setClickListener(this);
        bananaRecycler.setAdapter(bananaAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_banana, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void itemClick(View view, String name) {
        Intent intent = new Intent(this, ItemTrackActivity2.class);
        intent.putExtra("pestName", name);
        intent.putExtra("type", "dban_");
        startActivity(intent);
    }
}
