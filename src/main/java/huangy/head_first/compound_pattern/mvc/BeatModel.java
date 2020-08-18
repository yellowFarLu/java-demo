package huangy.head_first.compound_pattern.mvc;

import javax.sound.midi.*;
import java.util.ArrayList;

/**
 * 模型
 * @author huangy on 2019-06-09
 */
public class BeatModel implements BeatModelInterface, MetaEventListener {

    Sequencer sequencer;

    Sequence sequence;

    Track track;

    // 观察者列表（观察敲击）
    ArrayList<BeatObserver> beatObservers = new ArrayList<>();

    // 观察者列表（观察BPM）
    ArrayList<BPMObserver> BPMObservers = new ArrayList<>();

    int bpm = 90;

    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    @Override
    public void setBPM(int bpm) {
        System.out.println("model receive set bpm action");
        this.bpm = bpm;
        notifyBPMObservers();
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    void beatEvent() {
        notifyBeatObservers();
    }

    // 注册观察者
    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    // 有敲击事件发生的时候，通知观察者
    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver beatObserver = beatObservers.get(i);
            beatObserver.updateBeat();
        }
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        BPMObservers.add(observer);
    }

    public void notifyBPMObservers() {
        for (BPMObserver observer : BPMObservers) {
            observer.updateBPM();
        }
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        BPMObservers.remove(observer);
    }

    public void meta(MetaMessage metaMessage) {

        if (metaMessage.getType() == 47) {

            beatEvent();

            sequencer.start();

            setBPM(getBPM());
        }

    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = {35, 0, 46, 0};

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);

        track.add(makeEvevt(192, 9, 1, 0, 4));

        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            track.add(makeEvevt(144, 9, key, 100, i));
            track.add(makeEvevt(128, 9, key, 100, i + i));
        }
    }

    public MidiEvent makeEvevt(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
             ShortMessage a = new ShortMessage();
             a.setMessage(comd, chan, one, two);
             event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return event;
    }
}
