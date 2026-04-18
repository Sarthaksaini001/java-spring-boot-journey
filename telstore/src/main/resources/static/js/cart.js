async function createCart() {
    try {
        const response = await fetch("/carts", {
            method: "POST"
        });

        const cart = await response.json();
        localStorage.setItem("cartId", cart.id);
        document.getElementById("cart-id-display").textContent = cart.id;
        loadCart();
    } catch (error) {
        console.error(error);
        alert("Failed to create cart.");
    }
}

async function loadCart() {
    const cartId = localStorage.getItem("cartId");
    const cartItemsContainer = document.getElementById("cart-items");
    const cartIdDisplay = document.getElementById("cart-id-display");

    if (!cartId) {
        cartIdDisplay.textContent = "None";
        cartItemsContainer.innerHTML = `<p class="text-muted">No cart created yet.</p>`;
        return;
    }

    cartIdDisplay.textContent = cartId;

    try {
        const response = await fetch(`/carts/${cartId}`);
        const cart = await response.json();

        if (!cart.items || cart.items.length === 0) {
            cartItemsContainer.innerHTML = `<p class="text-muted">Your cart is empty.</p>`;
            return;
        }

        let html = `<div class="row g-3">`;

        cart.items.forEach(item => {
            html += `
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Cart Item #${item.id}</h5>
                            <p><strong>Product:</strong> ${item.product ? item.product.name : "None"}</p>
                            <p><strong>Plan:</strong> ${item.plan ? item.plan.name : "None"}</p>
                            <p><strong>Quantity:</strong> ${item.quantity}</p>
                            <button class="btn btn-danger btn-sm" onclick="removeItem(${item.id})">
                                Remove
                            </button>
                        </div>
                    </div>
                </div>
            `;
        });

        html += `</div>`;
        cartItemsContainer.innerHTML = html;
        loadCartTotal(cartId);
        
    } catch (error) {
        console.error(error);
        cartItemsContainer.innerHTML = `<p class="text-danger">Failed to load cart.</p>`;
    }
}

async function removeItem(cartItemId) {
    const cartId = localStorage.getItem("cartId");

    if (!cartId) return;

    try {
        const response = await fetch(`/carts/${cartId}/items/${cartItemId}`, {
            method: "DELETE"
        });

        if (response.ok) {
            loadCart();
        } else {
            const errorData = await response.json();
            alert(errorData.message || "Failed to remove item.");
        }
    } catch (error) {
        console.error(error);
        alert("Error removing item.");
    }
}

async function loadCartTotal(cartId) {
    try {
        const response = await fetch(`/carts/${cartId}/total`);
        const total = await response.json();

        document.getElementById("cart-total").textContent = total;
    } catch (error) {
        console.error("Failed to load total", error);
    }
}

loadCart();