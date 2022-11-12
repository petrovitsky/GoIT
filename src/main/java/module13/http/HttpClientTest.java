package module13.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import module7.lesson.User;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpClientTest {

    public static void main(String[] args) throws Exception {

        System.out.println(getAllUsers());
        UserDTO user1 = getUserByID(499);
        user1.setName("Query");
        final UserDTO updateUserBytID = updateUserBytID(499, user1);
        System.out.println(updateUserBytID);

        System.out.println(getAllUsers());

    }

    private static List<UserDTO> getAllUsers() throws IOException, InterruptedException {
        return new Gson().fromJson(HttpClient.newBuilder().build().send(HttpRequest.newBuilder(URI.create(Uri.GET_ALL_USERS))
                .GET().build(), HttpResponse.BodyHandlers.ofString()).body(), TypeToken.getParameterized(List.class, UserDTO.class).getType());
    }

    private static String addUser(UserDTO user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Uri.CREATE_USER))
                .POST(HttpRequest.BodyPublishers.ofString(new Gson().toJson(user)))
                .setHeader("Content-type", "application/json")
                .build();
        return HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString()).body();
    }
    private static UserDTO getUserByID(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Uri.GET_USER_BY_ID + id))
                .GET()
                .build();
        return new Gson().fromJson(HttpClient.newBuilder().build()
                .send(request, HttpResponse.BodyHandlers.ofString()).body(), UserDTO.class);
    }



    private static <T> boolean removeUser (T user) throws Exception {
        final String response = HttpClient.newHttpClient().send
                (HttpRequest.newBuilder()
                                .uri(URI.create(Uri.REMOVE_USER))
                                .setHeader("Content-type", "application/json")
                                .method("DELETE", HttpRequest
                                        .BodyPublishers.ofString(new Gson().toJson(user)))
                                .build()
                ,HttpResponse.BodyHandlers.ofString())
                .body();
        return Boolean.parseBoolean(response);
    }

    private static UserDTO jsonToUser (String gson){
        return new Gson().fromJson(gson, UserDTO.class);
    }

    private static String userToJson (UserDTO user){
        return new Gson().toJson(user);
    }

    private static UserDTO updateUserBytID(int id, UserDTO newUser) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(Uri.UPDATE_USER + id))
                .PUT(HttpRequest.BodyPublishers.ofString(new Gson().toJson(newUser)))
                .setHeader("Content-type", "application/json")
                .build();
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return jsonToUser(response.body());
    }

}


