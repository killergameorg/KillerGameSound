package sound.killergamesound.SoundModel;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BackgroundSound {
    private MediaPlayer mediaPlayer;
    private static final String SOUNDS_DIR = "Sounds/";

    public void reproduceMusic(Media media){
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(0.1); // Ajusta el volumen según sea necesario
        new Thread(()->{
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.setOnReady(mediaPlayer::play);
        }).start();

    }

    public void reproduceCombat() {
        stopMusic(getMediaPlayer());
        try {
            String combatMusicFile = SOUNDS_DIR + MusicType.COMBAT.getFileName();
            Media media = new Media(new File(combatMusicFile).toURI().toString());
            reproduceMusic(media);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void reproduceCalm() {
        stopMusic(getMediaPlayer());
        try {
            String calmMusicFile = SOUNDS_DIR + MusicType.CALMA.getFileName();
            Media media = new Media(new File(calmMusicFile).toURI().toString());
            reproduceMusic(media);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stopMusic(MediaPlayer mediaPlayer) {
        if (mediaPlayer!=null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }


}