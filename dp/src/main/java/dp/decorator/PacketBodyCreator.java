package dp.decorator;

public class PacketBodyCreator implements IPacketCreator {
    @Override
    public String handlerContent() {
        return "Content of Packet";
    }
}
