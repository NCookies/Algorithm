class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self, head_value):
        self.head = Node(head_value)

    def append(self, value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next

        cur.next = Node(value)

    def print_list(self):
        cur = self.head
        while cur.next is not None:
            print(cur.data)
            cur = cur.next
        print(cur.data)

    def get_node(self, index):
        cur = self.head
        cur_index = 0

        while cur_index < index:
            cur_index += 1
            cur = cur.next

        return cur

    def add_node(self, index, value):
        new_node = Node(value)
        prev_node = self.get_node(index - 1)

        next_node = prev_node.next
        prev_node.next = new_node
        new_node.next = next_node

        return new_node

    def delete_node(self, index):
        prev_node = self.get_node(index - 1)
        prev_node.next = prev_node.next.next

    def get_sum(self):
        node_sum = 0
        cur = self.head

        while cur is not None:
            node_sum = node_sum * 10 + cur.data
            cur = cur.next

        print(node_sum)
        return node_sum

linked_list_1 = LinkedList(6)
linked_list_1.append(7)
linked_list_1.append(8)

linked_list_2 = LinkedList(3)
linked_list_2.append(5)
linked_list_2.append(4)

linked_list_1.get_sum()
linked_list_2.get_sum()