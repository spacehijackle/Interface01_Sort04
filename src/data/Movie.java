package data;

import java.util.Calendar;


/**
 * 映画クラス
 *
 * @author t.yoshida
 */
public class Movie
{
	// アイコン
	private String _icon;

	// タイトル
	private String _title;

	// リリース年月日
	private Calendar _released;

	/**
	 * 映画タイトルを生成する。
	 *
	 * @param icon アイコン（絵文字）
	 * @param title タイトル
	 * @param released リリース年月日
	 */
	public Movie(String icon, String title, Calendar released)
	{
		_icon = icon;
		_title = title;
		_released = released;
	}

	/**
	 * タイトルを返す。
	 *
	 * @return タイトル
	 */
	public String getTitle()
	{
		return _title;
	}

	/**
	 * 公開日付を返す。
	 *
	 * @return 公開日付
	 */
	public Calendar getReleased()
	{
		return _released;
	}

	@Override
	public String toString()
	{
		return "'" + (_released.get(Calendar.YEAR) - 1900) + " " + _icon + _title;
	}
}
