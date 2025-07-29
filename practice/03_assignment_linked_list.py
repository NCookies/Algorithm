class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self, value):
        self.head = Node(value)

    def append(self, value):
        cur = self.head
        while cur.next is not None:
            cur = cur.next

        cur.next = Node(value)

    def get_kth_node_from_last(self, k):
        target_index = self.get_length() - k + 1
        cur_index = 0
        cur = self.head

        while cur_index < target_index - 1:
            cur = cur.next
            cur_index += 1

        return cur.data

    def get_length(self):
        cur = self.head
        length = 1
        while cur.next is not None:
            length += 1
            cur = cur.next

        return length

linked_list = LinkedList(5)
linked_list.append(6)
linked_list.append(7)
print(linked_list.get_length())

print(linked_list.get_kth_node_from_last(2))
