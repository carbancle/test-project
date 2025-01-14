package vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order {
	
	private int no;
	private Member member;
	private String status; //주문상태
	private Date orderDate;
	private int totalPrice;
	private String cancelReason;
	private String cancelStatus;
	private Date canceledDate;
	private String reviewStatus;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelStatus() {
		return cancelStatus;
	}

	public void setCancelStatus(String cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	public Date getCanceledDate() {
		return canceledDate;
	}

	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [no=" + no + ", member=" + member + ", status=" + status + ", orderDate=" + orderDate
				+ ", totalPrice=" + totalPrice + ", cancelReason=" + cancelReason + ", cancelStatus=" + cancelStatus
				+ ", canceledDate=" + canceledDate + ", reviewStatus=" + reviewStatus + ", items=" + items + "]";
	}
	
}
