package kr.or.womanup.nambu.hjy.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification("ch01","총무부",R.mipmap.ic_launcher,
                        "타이틀","알람 내용",10);

/*                NotificationCompat.Builder builder;
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){//오레오 이후 버전만 채널 지원.
                    //채널 만들기. 앱별 알림이 아니라 하나의 앱 안에 여러 채널별 알림 가능
                    NotificationChannel channel =
                            new NotificationChannel("ch01","총무부", NotificationManager.IMPORTANCE_DEFAULT);
                    channel.enableLights(true); //라이트 허용. 안되는 폰들도 있음.
                    channel.enableVibration(true); //진동 허용

                    //안드로이드 시스템에 서비스요청
                    NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    //안드로이드 시스템(매니저)에 채널 등록
                    manager.createNotificationChannel(channel);

                    //Notification 만들기와 설정. builder가 notification 만들어줌.
                    builder = new NotificationCompat.Builder(MainActivity.this,"ch01");
                    builder.setSmallIcon(R.mipmap.ic_launcher);
                    builder.setContentTitle("Notification Title");
                    builder.setContentText("Notification Text"); //알람 내용
                    builder.setNumber(1); //알람 수에 따라 수 증가시키기
                    Notification noti = builder.build();

                    manager.notify(10, noti); //id가 중복되면 마지막 알림만 보여줌

                }else {
                    builder = new NotificationCompat.Builder(MainActivity.this);
                    builder.setContentTitle("Notification Title");
                    builder.setContentText("Notification Text");
                    builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                    builder.setNumber(1);
                    Notification noti = builder.build();
                    NotificationManager manager =
                            (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    manager.notify(10,noti);
                }*/
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                sendNotification("ch01","총무부",R.mipmap.ic_launcher,
                        "총무부 타이틀","총무부 알림 내용입니다",20);
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification("ch02","영업부",R.mipmap.ic_launcher,
                        "영업부 타이틀","영업부 알림 내용",20);
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //사진 알림 띄우기
                NotificationCompat.Builder builder = getNotificationBuilder("ch02","하하하");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                //스타일 만들 때 빌더와 연결시켰음
                NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle(builder);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ddongddang);
                style.bigPicture(bitmap);
                style.setBigContentTitle("뚱땅이");
                style.setSummaryText("뚱땅이가 인사합니다!");

                Notification noti = builder.build();
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(60,noti);
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "프랑스의 한 남성이 러시아 미술관에 사는 고양이들에게 유산 일부를 남겨 화제다.\n" +
                        "8일(현지시간) 미국 CNN방송에 따르면 익명의 프랑스 자선가는 “내가 죽으면 러시아 상트페테르부르크의 예르미타시 미술관에 사는 고양이 50여 마리에게 소액을 기부해달라”고 유언장에 적었다.\n" +
                        "\n" +
                        "미술관 관리 책임자인 미하일 피오트로프스키는 “상속된 금액은 고양이들이 거주하는 미술관 지하실을 수리하는 데 사용할 것”이라고 밝혔다.\n" +
                        "\n" +
                        "‘겨울 궁전’으로도 알려진 예르미타시 미술관은 프랑스의 루브르, 영국의 대영박물관과 더불어 세계 3대 박물관으로 꼽힌다. 현재 300만 점의 예술품과 유물, 조각품 등을 보유하고 있다.";
                NotificationCompat.Builder builder = getNotificationBuilder("ch04", "러시아고양이");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle(builder);
                style.setBigContentTitle("빅 테스트 타이틀");
                style.bigText(text);

                Notification noti = builder.build();
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager.notify(90,noti);
            }
        });

    }

    private void sendNotification(String chID,String chName, int samllIcon, String title,
                                  String text, int id) {
        NotificationCompat.Builder builder = getNotificationBuilder(chID,chName);
        builder.setSmallIcon(samllIcon);
        builder.setContentTitle(title);
        builder.setContentText(text);
        Notification noti = builder.build();
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(id,noti);
    }

    public NotificationCompat.Builder getNotificationBuilder(String chID, String chName){
        NotificationCompat.Builder builder;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel =
                    new NotificationChannel(chID,chName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableVibration(true);
            //다른 함수에서 썼어도 같은 manager가 옴. 시스템 상 하나가 있다.
            NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(MainActivity.this,chID);
        }else {
            builder = new NotificationCompat.Builder(MainActivity.this);
        }
        return builder;
    }
}