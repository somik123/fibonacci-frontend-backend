import axios from "axios";

const API_BASE_URL = "http://130.162.245.46:8080/fibonacci";


class APIDataService {
    getFibonacci(FibRequest) {
      return axios.post(API_BASE_URL, FibRequest);
    }
}

export default new APIDataService();
