package com.ziadsyahrul.tugasmvp.main;

import android.service.autofill.UserData;

import com.ziadsyahrul.tugasmvp.model.FootballData;

import java.util.List;

public interface MainContract {
    interface View{
        void showProgress();
        void hideProgress();
        // Menampilkan data list view
        void showDataListUser(List<FootballData> footballDataList);

        // Menampilkan pesan gagal
        void showFailureMessage(String msg);

    }

    interface Presenter{
        // Membuat method untuk mengambil data dari ap
        void getDataListUser();
    }
}
