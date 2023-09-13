package hash_table;

public class HashTable {
    private static class Entry {
        int hash;
        Object key;
        Object value;
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    Entry[] table = new Entry[16];
    int size = 0;
    float loadFactor = 0.75f;
    int threshold = (int) (table.length * loadFactor);

    private int useHash(Object key) {
        int hash = key.hashCode();
        return hash ^ (hash >>> 16);
    }

    private Object get(int hash, Object key) {
        int index = hash & (table.length - 1);
        Entry target = table[index];

        if (target == null) return null;

        while (target != null) {
            if (target.key.equals(key)) {
                return target.value;
            }
            target = target.next;
        }

        return null;
    }

    public Object get(Object key) {
        int hash = useHash(key);

        return get(hash, key);
    }

    private void put(int hash, Object key, Object value) {
        int index = hash & (table.length - 1);
        Entry target = table[index];

        if (target == null) {
            table[index] = new Entry(hash, key, value);
        } else {
            while (true) {
                if (target.key.equals(key)) {
                    target.value = value;
                    return;
                }
                if (target.next == null) {
                    target.next = new Entry(hash, key, value);
                    break;
                }
                target = target.next;
            }
        }
        size++;

        if (size > threshold) {
            resize();
        }
    }

    public void put(Object key, Object value) {
        int hash = useHash(key);
        put(hash, key, value);
    }

    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];

        for (int i = 0; i < table.length; i++) {
            Entry current = table[i];
            Entry a = null;
            Entry b = null;
            Entry aHead = null;
            Entry bHead = null;

            while (current != null) {
                if ((current.hash & table.length) == 0) {
                    if (a == null) {
                        aHead = current;
                    } else {
                        a.next = current;
                    }
                    a = current;
                } else {
                    if (b == null) {
                        bHead = current;
                    } else {
                        b.next = current;
                    }
                    b = current;
                }
                current = current.next;
            }
            if (a != null) {
                a.next = null;
                newTable[i] = aHead;
            }
            if (b != null) {
                b.next = null;
                newTable[i + table.length] = bHead;
            }
            table = newTable;
            threshold = (int) (table.length * loadFactor);
        }
    }

    private Object remove(int hash, Object key) {
        int index = hash & (table.length - 1);
        Entry target = table[index];
        Entry parent = null;

        if (target == null) return null;

        while (target != null) {
            if (target.key.equals(key)) {
                if (parent == null) {
                    table[index] = target.next;
                } else {
                    parent.next = target.next;
                }
                size--;

                return target.value;
            }


            parent = target;
            target = target.next;
        }

        return null;
    }

    public Object remove(Object key) {
        int hash = useHash(key);

        return remove(hash, key);
    }
}
