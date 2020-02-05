package agua.agua.co.mz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import agua.agua.co.mz.ui.GerenciamentoFragment;
import agua.agua.co.mz.ui.ListaClientesFragment;
import agua.agua.co.mz.ui.MapaFragment;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private static final String clientes = "Clientes";
    private static final String mapa = "Mapa";
    private static final String gerenciamento = "Gerenciamento";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Matiguenta");
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.view_pager);


        setSupportActionBar(toolbar);

        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    private void setupViewPager(ViewPager viewPager){


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ListaClientesFragment() , "Clientes");
        viewPagerAdapter.addFragment(new MapaFragment() , "Mapa");
        viewPagerAdapter.addFragment(new GerenciamentoFragment() , "Gerenciamento");


        viewPager.setAdapter(viewPagerAdapter);



    }


}