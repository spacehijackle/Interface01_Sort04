package main;

import java.util.Calendar;

import com.sort.SortComparator;
import com.sort.Sorter;

import data.Human;
import data.Movie;


/**
 * 任意クラスのソート処理
 *
 * @author t.yoshida
 */
public class Startup
{
	public static void main(String[] args)
	{
		/*
		 * 身長の小さい順に並び替え
		 */
		System.out.println("─ 身長で並び替え ────────────────────");
		Human[] humans1 = createHumans();
		System.out.println(" [使用前] " + toString(humans1));
		Sorter.selectionSort(humans1, new SortComparator<Human>()
		{
			@Override
			public boolean isNeedToExchange(Human h1, Human h2)
			{
				return (h1.getHeight() > h2.getHeight());
			}
		});
		System.out.println(" [使用後] " + toString(humans1));

		System.out.println();

		/*
		 * 公開年の古い順に並び替え
		 */
		System.out.println("─ 公開年で並び替え ───────────────────");
		Movie[] movies1 = createMovies();
		System.out.println(" [使用前] " + toString(movies1));
		Sorter.selectionSort(movies1, new SortComparator<Movie>()
		{
			@Override
			public boolean isNeedToExchange(Movie m1, Movie m2)
			{
				return (m1.getReleased().after(m2.getReleased()));
			}
		});
		System.out.println(" [使用後] " + toString(movies1));
	}

	/**
	 * 人間配列データの生成
	 *
	 * @return 人間配列データ
	 */
	private static Human[] createHumans()
	{
		Human[] girls =
		{
			new Human("👩", "ミユウ", 21, 159), new Human("💁", "しゅう", 20, 154),
			new Human("👸", "ふぅ香", 24, 152), new Human("👧", "みう希", 23, 153),
		};

		return girls;
	}

	/*
	 * 映画タイトル配列データの生成
	 */
	private static Movie[] createMovies()
	{
		Movie[] movies =
		{
			new Movie("💣", "戦国自営業", createCalendar(1979, 12, 5)),
			new Movie("🌠", "ギャルの惑星", createCalendar(1968, 2, 8)),
			//new Movie("🌠", "続・ギャルの惑星", createCalendar(1970, 5, 26)),
			new Movie("👊", "空手アホ一代", createCalendar(1977, 5, 14)),
			new Movie("👣", "2001年府中の旅", createCalendar(1968, 4, 6)),
		};

		return movies;
	}

	/*
	 * 指定された年月日を {@link Calendar} に変換する。
	 *
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @return 変換後カレンダー
	 */
	private static Calendar createCalendar(int year, int month, int day)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, (month - 1), day, 0, 0, 0);

		return calendar;
	}

	/*
	 * 配列データを文字列として連結する。
	 */
	private static String toString(Object[] targets)
	{
		StringBuilder sb = new StringBuilder(50);
		for(int i=0; i<targets.length; i++)
		{
			if(i != 0)
			{
				sb.append(", ");
			}
			sb.append(targets[i].toString());
		}

		return sb.toString();
	}
}
