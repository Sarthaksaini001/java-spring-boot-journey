async function loadPlans() {
    const planList = document.getElementById("plan-list");

    try {
        const response = await fetch("/plans");
        const plans = await response.json();

        planList.innerHTML = "";

        plans.forEach(plan => {
            const card = document.createElement("div");
            card.className = "col-md-4";

            card.innerHTML = `
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">${plan.name}</h5>
                        <h6 class="text-muted">${plan.planType}</h6>
                        <p class="card-text">${plan.description}</p>
                        <p><strong>Data:</strong> ${plan.dataLimit}</p>
                        <p><strong>Calls:</strong> ${plan.callsIncluded}</p>
                        <p><strong>SMS:</strong> ${plan.smsIncluded}</p>
                        <p><strong>Monthly Price:</strong> $${plan.monthlyPrice}</p>
                        <button class="btn btn-primary" onclick="addPlanToCart(${plan.id})">
                            Add Plan
                        </button>
                    </div>
                </div>
            `;

            planList.appendChild(card);
        });
    } catch (error) {
        planList.innerHTML = `<p class="text-danger">Failed to load plans.</p>`;
        console.error(error);
    }
}

async function addPlanToCart(planId) {
    const cartId = localStorage.getItem("cartId");

    if (!cartId) {
        alert("No cart found. Please create a cart first from the cart page.");
        return;
    }

    try {
        const response = await fetch(`/carts/${cartId}/items`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                productId: null,
                planId: planId,
                quantity: 1
            })
        });

        if (response.ok) {
            alert("Plan added to cart!");
        } else {
            const errorData = await response.json();
            alert(errorData.message || "Failed to add plan to cart.");
        }
    } catch (error) {
        console.error(error);
        alert("Error adding plan to cart.");
    }
}

loadPlans();