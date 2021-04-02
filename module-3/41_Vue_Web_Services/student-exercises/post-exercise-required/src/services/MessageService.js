import axios from 'axios';
import { delete } from 'vue/types/umd';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },
  save(message){
    return http.post(`/messages`, message);
  },
  update(id){
    return http.put(`/messages/${id}`);
  },
  delete(id){
    return http.delete(`/messages/${id}`);
  }

}
