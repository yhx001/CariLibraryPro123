/**
 * 
 */
package cn.com.cari.carilibrary.Util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @Title: EditTextUtil
 * @Description: 
 * @Company: www.cari.com.cn
 * @author zhouzhou
 * @date 2015-11-9 上午10:04:16
 */
public class EditTextUtil {
	/**
	 * 监听EditText只能输入小数点后两位
	 * @param editText
	 */
	public static void setPricePoint(final EditText editText) {
		editText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.toString().contains(".")) {
					if (s.length() - 1 - s.toString().indexOf(".") > 2) {
						s = s.toString().subSequence(0,
								s.toString().indexOf(".") + 3);
						editText.setText(s);
						editText.setSelection(s.length());
					}
				}
				if (s.toString().trim().substring(0).equals(".")) {
					s = "0" + s;
					editText.setText(s);
					editText.setSelection(2);
				}

				if (s.toString().startsWith("0")
						&& s.toString().trim().length() > 1) {
					if (!s.toString().substring(1, 2).equals(".")) {
						editText.setText(s.subSequence(0, 1));
						editText.setSelection(1);
						return;
					}
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

		});

	}
}
