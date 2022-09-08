package com.chardatasave;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.game.ItemManager;
import okhttp3.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.*;

//import com.chardatasave.data.death.DeathBuilder;
import com.chardatasave.data.hitsplat.HitsplatBuilder;
import com.chardatasave.data.player.PlayerDataBuilder;



@Slf4j
@AllArgsConstructor
public class CharDataSaveClient
{

    private Client client;
    private ItemManager itemManager;
    private CharDataSaveConfig config;
//    private OkHttpClient okClient;

    public void sendHitsplat(int damage, String targetName)
    {
        HitsplatBuilder builder = new HitsplatBuilder(client);
        builder.setDamage(damage);
        builder.setTargetName(targetName != null ? targetName : "");
        post(builder.build());
    }

    public void sendCombatLog(String targetName, boolean isAttacking)
    {
        PlayerDataBuilder builder = new PlayerDataBuilder(client, itemManager, targetName, isAttacking);
        post(builder.build());
    }

    public void sendInventoryChangeLog() {
        PlayerDataBuilder builder = new PlayerDataBuilder(client, itemManager);
        post(builder.build());
    }

    private void post(Object obj) {
        String filePath = "temp.json";

        Gson gson = new Gson();

//        gson.toJson(obj, new FileWriter(filePath));
        String json = gson.toJson(obj);

        System.out.println(json);

        int server_port = 6000;
        int msg_length = json.length();
        byte[] message = json.getBytes();

        try {
            DatagramSocket s = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        DatagramSocket s = null;
        try {
            s = new DatagramSocket();
            System.out.println("opened socket");

        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("failed to open socket");

        }

        DatagramPacket p = null;
        try {
            p = new DatagramPacket(message, msg_length, InetAddress.getByName("localhost"), server_port);
            System.out.println("should have sent");
        } catch (UnknownHostException e) {
            System.out.println("didnt sent 1");

            throw new RuntimeException(e);
        }
        try {
            s.send(p);
            System.out.println("should have sent2");

        } catch (IOException e) {
            System.out.println("didnt send 2");

            e.printStackTrace();
        }




//        // automatically include a "/" at the end of the initial endpoint URL if it wasn't included
//        String endpoint = config.endpoint().endsWith("/") ? config.endpoint() : config.endpoint() + "/";
//
//        HttpUrl url = HttpUrl.parse(endpoint + LOG_ENDPOINT);
//        MediaType mt = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body = RequestBody.create(mt, json);
//
//        Request request = new Request.Builder().url(url).post(body).build();
//        okClient.newCall(request).enqueue(new Callback()
//        {
//            @Override
//            public void onFailure(Call call, IOException e)
//            {
//                log.warn("Failure");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException
//            {
//                log.info("Code: {} - Response: {}", response.code(), response.body().string());
//                response.close();
//            }
//        });
    }
}
