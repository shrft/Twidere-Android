/*
 * 				Twidere - Twitter client for Android
 * 
 *  Copyright (C) 2012-2014 Mariotaku Lee <mariotaku.lee@gmail.com>
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import org.mariotaku.twidere.R;
import org.mariotaku.twidere.util.Utils;

public class AccountRefreshSettingsFragment extends BaseAccountPreferenceFragment {

    @Override
    protected int getPreferencesResource() {
        return R.xml.preferences_account_refresh;
    }

    @Override
    protected boolean getSwitchPreferenceDefault() {
        return DEFAULT_AUTO_REFRESH;
    }

    @Override
    @Nullable
    protected String getSwitchPreferenceKey() {
        return null;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        final Activity activity = getActivity();
        if (activity == null) return;
        if (KEY_AUTO_REFRESH.equals(key)) {
            Utils.startRefreshServiceIfNeeded(activity);
        }
    }
}
