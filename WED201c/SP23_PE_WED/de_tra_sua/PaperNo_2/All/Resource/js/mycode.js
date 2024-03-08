function CalTotal() {
    let total = 0, menuListOrder = document.querySelectorAll('.menu-list')[0],
        menuListCart = document.querySelectorAll('.menu-list')[1],
        totalPrice = document.querySelector('#total-price'),
        checkedItems = menuListOrder.querySelectorAll('input[type="checkbox"]:checked'),
        menuListFooter = document.querySelector('.menu-list_footer'),
        menuListCartContent = menuListCart.querySelector('.menu-list_content');

    menuListCartContent.innerHTML = '';
    checkedItems.forEach(item => {
        const itemLabel = item.parentElement.querySelector('label').innerText;
        total += Number(item.value);
        menuListCartContent.innerHTML += `
            <div class="menu-list_item">
                <div>
                    <label>${itemLabel}</label>
                </div>
            </div>
        `;
    });
    totalPrice.innerText = `${total}$`;
    if (total > 0) {
        menuListFooter.style.display = 'block';
    } else {
        menuListFooter.style.display = 'none';
    }
}