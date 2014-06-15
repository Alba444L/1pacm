import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class libreriaAudio {

	private URL audio = this.getClass().getResource("atepellot.wav");
	public  final AudioClip BALL = Applet.newAudioClip( audio);
	private URL audio_muerte_pacman = this.getClass().getResource("died.wav");
	public final AudioClip muerePacman = Applet.newAudioClip(audio_muerte_pacman);
	
	
	public void musica(){
		URL url = this.getClass().getResource("intro.wav");
		AudioClip clip = Applet.newAudioClip(url);
		
		clip.play();
		try {
			Thread.sleep(4500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			}
}