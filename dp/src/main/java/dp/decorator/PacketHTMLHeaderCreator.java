package dp.decorator;

public class PacketHTMLHeaderCreator extends PacketDecorator {


    public PacketHTMLHeaderCreator(IPacketCreator c) {
        super(c);
    }

    @Override
    public String handlerContent() {
        return "html"+component.handlerContent()+"html";
    }
}
