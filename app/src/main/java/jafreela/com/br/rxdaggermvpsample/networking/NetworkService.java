package jafreela.com.br.rxdaggermvpsample.networking;


import jafreela.com.br.rxdaggermvpsample.models.CityListResponse;
import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();

}
