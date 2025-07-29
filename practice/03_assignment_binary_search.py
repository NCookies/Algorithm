menu_list = ["떡볶이", "만두", "오뎅", "사이다", "콜라"]
order_list = ["오뎅", "콜라", "만두", "환타"]

def print_available_orders(menus, orders):
    menus_set = set(menus)
    availables = []

    for order_item in orders:
        if order_item in menus_set:
            availables.append(order_item)

    print(availables)

print_available_orders(menu_list, order_list)
