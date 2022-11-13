package module13.homework;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Homework {
    public static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    public static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException, InterruptedException {
        UserDTO userTest = getUserById(5);
        userTest.setName("Taras");
        userTest.setUsername("Bulba");
        userTest.setWebsite("wiki.org");

        //Task1
        System.out.println("\nTask1   -------- --------- --------- -------- \n");
        System.out.println("createUser(new UserDTO()) = " + createUser(userTest));
        System.out.println("update user " + updateUser(1,userTest));
        System.out.print("delete user");
        deleteUser(5);
        final List<UserDTO> allUsers = getAllUsers();
        allUsers.forEach(System.out::println);
        System.out.println("getUserById(6) = " + getUserById(6));
        System.out.println("getUserByUserName(\"Moriah.Stanton\") = " + getUserByUserName("Moriah.Stanton"));

        //Task2
        System.out.println("\nTask2   -------- --------- --------- -------- \n");

        printAndWriteToFileCommentsOnLastPost(7);

        System.out.println("\nTask3   -------- --------- --------- -------- \n");

        uncompletedUserTasks(9);
    }

    private static void printAndWriteToFileCommentsOnLastPost(int userId) throws IOException, InterruptedException {
        String url = String.format("https://jsonplaceholder.typicode.com/posts?userId=%d", userId);
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();

        List<UserPostDTO> list = GSON.fromJson(HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body()
                , TypeToken.getParameterized(List.class, UserPostDTO.class).getType());
        int maxId = list.stream().mapToInt(id -> id.getId()).max().getAsInt();

        url = String.format("https://jsonplaceholder.typicode.com/comments?postId=%d", maxId);
        request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        System.out.println(HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body());
        HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofFile(new File(String.format("user-%d-post-%d-comments.json", userId, maxId)).toPath()));
    }


    public static UserDTO createUser(UserDTO userToCreate) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.USERS_URL))
                .POST(HttpRequest.BodyPublishers.ofString(GSON.toJson(userToCreate)))
                .header("Content-type", "application/json")
                .build();
        String body = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
        return GSON.fromJson(body, UserDTO.class);
    }

    public static List<UserDTO> getAllUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.USERS_URL))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), TypeToken.getParameterized(List.class, UserDTO.class).getType());
    }

    public static UserDTO getUserById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.USER_BY_ID_URL + id))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), UserDTO.class);

    }

    public static UserDTO getUserByUserName(String userName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.USER_BY_USERNAME_URL + userName))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<UserDTO> result = GSON.fromJson(response.body(), TypeToken.getParameterized(List.class, UserDTO.class).getType());
        return result.get(0);

    }


    public static UserDTO updateUser(int id, UserDTO userToUpdate) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Constants.USER_BY_ID_URL + id))
                .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(userToUpdate)))
                .header("Content-type", "application/json")
                .build();
        String body = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body();
        return GSON.fromJson(body, UserDTO.class);
    }

    public static void deleteUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(Constants.USER_BY_ID_URL + id))
                .DELETE()
                .build();
        final HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.statusCode() = " + response.statusCode());

    }

    public static void uncompletedUserTasks(int userId) throws IOException, InterruptedException {
        String url = String.format("https://jsonplaceholder.typicode.com/users/%d/todos?completed=false", userId);
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();
        System.out.println(HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString()).body());

    }

}
