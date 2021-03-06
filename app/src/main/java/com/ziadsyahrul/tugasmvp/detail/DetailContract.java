package com.ziadsyahrul.tugasmvp.detail;

import android.os.Bundle;

import com.ziadsyahrul.tugasmvp.model.FootballData;

import java.util.List;

public interface DetailContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataFootball(List<FootballData> footballData);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataFootball(Bundle bundle);
    }
}
