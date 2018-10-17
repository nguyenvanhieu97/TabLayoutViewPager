package com.cris.nvh.tablayoutviewpager;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private int[] resources = {R.drawable.cycler, R.drawable.pink_heart, R.drawable.mahjong};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
		PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager, true);
		setTabIcon(adapter, tabLayout, resources);
	}

	public void setTabIcon(PagerAdapter pagerAdapter, TabLayout tabLayout, int[] resources) {
		for (int i = 0; i < pagerAdapter.getCount(); i++) {
			tabLayout.getTabAt(i).setIcon(resources[i]);
		}
	}

	public class PagerAdapter extends FragmentStatePagerAdapter {
		private ArrayList<Fragment> mListFragments = new ArrayList<>();
		private String[] mTabTitles = {"Tab 1", "Tab 2", "Tab 3"};

		public PagerAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
			mListFragments.add(new LeftFragment());
			mListFragments.add(new CenterFragment());
			mListFragments.add(new RightFragment());
		}

		@Override
		public Fragment getItem(int i) {
			return mListFragments.get(i);
		}

		@Override
		public int getCount() {
			return mListFragments.size();
		}

		@Nullable
		@Override
		public CharSequence getPageTitle(int position) {
			return mTabTitles[position];
		}
	}
}
