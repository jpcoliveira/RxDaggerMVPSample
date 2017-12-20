package jafreela.com.br.rxdaggermvpsample.source;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joliveira on 20/12/17.
 */
@Module
public class PreferenceModule {

    private Context mContext;

    public PreferenceModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public SharedPreferences provideSharePreference(Context context) {
        return context.getSharedPreferences("PREF_KEY", Context.MODE_PRIVATE);
    }
}
