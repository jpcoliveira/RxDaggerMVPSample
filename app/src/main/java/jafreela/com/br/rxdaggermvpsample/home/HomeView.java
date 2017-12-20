package jafreela.com.br.rxdaggermvpsample.home;


import jafreela.com.br.rxdaggermvpsample.models.CityListResponse;

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCityListSuccess(CityListResponse cityListResponse);

}
