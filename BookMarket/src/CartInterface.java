public interface CartInterface {
    //범용성을 위해 cart의 컨트롤들을 본을 뜨는 식으로 변형
    //cart에 오버라이드 하기.
    boolean isCartInItem(String id);
    void clearCart();
    Item removeCartItem(String id);
    void appendItem(Item item);
    void inCreaseItemCount(String id);
    Item deCreaseItemCount(String id);
//    void removeCartItem(int index);
    void printCart();
}
// 오버라이드 하려면 이름 자료형 및 리턴 값 다 같아야 한다. 범용성을 위해서
// 여기에 맞춰준다.