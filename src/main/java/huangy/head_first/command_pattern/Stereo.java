package huangy.head_first.command_pattern;

/**
 * 音响
 * @author huangy on 2019-05-25
 */
public class Stereo {

    private String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + "Stereo on");
    }

    public void setCD() {
        System.out.println(name + "Stereo setCD");
    }

    // 设置音量
    public void setVolume(int volume) {
        System.out.println(name + "Stereo setVolume=" + volume);
    }

    public void off() {
        System.out.println(name + "Stereo off");
    }

    @Override
    public String toString() {
        return "Stereo{" +
                "name='" + name + '\'' +
                '}';
    }
}
