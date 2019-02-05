package com.ziadsyahrul.tugasmvp.main;

import com.ziadsyahrul.tugasmvp.model.FootballResponse;
import com.ziadsyahrul.tugasmvp.network.ApiClient;
import com.ziadsyahrul.tugasmvp.network.ApiInterface;
import com.ziadsyahrul.tugasmvp.utils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


    @Override
    public void getDataListUser() {
        view.showProgress();

        Call<FootballResponse> call = apiInterface.getFootballResponse(Constant.l);
        call.enqueue(new Callback<FootballResponse>() {
            @Override
            public void onResponse(Call<FootballResponse> call, Response<FootballResponse> response) {
                view.hideProgress();

                if (response.body() != null){
                    FootballResponse footballResponse = response.body();

                    if (footballResponse.getTeams() != null){
                        view.showDataListUser(footballResponse.getTeams());
                    }
                }
            }

            @Override
            public void onFailure(Call<FootballResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessage(t.getMessage());
            }
        });
    }
}
