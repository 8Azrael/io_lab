package put.io.patterns.implement;

public class USBDeviceObserver implements  SystemStateObserver{
    private SystemState lastSystemState = null;
    private int USB_count = 0;
    public void update(SystemMonitor monitor){
        lastSystemState = monitor.getLastSystemState();
        if (lastSystemState.getUsbDevices() > USB_count){
            System.out.println("> New USB device connected");
        }
        else if (lastSystemState.getUsbDevices() < USB_count){
            System.out.println("> USB device disconnected");
        }
        USB_count = lastSystemState.getUsbDevices();
    }
}
