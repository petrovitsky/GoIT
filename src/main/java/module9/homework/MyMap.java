package module9.homework;

/*
* Задание 5 - HashMap
Написать свой класс MyHashMap как аналог классу HashMap.

Нужно делать с помощью односвязной Node.

Не может хранить две ноды с одинаковых ключами одновременно.

Методы

*put(Object key, Object value) добавляет пару ключ + значение
*remove(Object key) удаляет пару по ключу
*clear() очищает коллекцию
*size() возвращает размер коллекции
get(Object key) возвращает значение(Object value) по ключу*/


public interface MyMap<K,V>  {
     V put(K key, V value);

     V remove(Object key);

     void clear();

     int size();

     V get(Object key);

     interface Entry<K, V> {
          K getKey();

          /**
           * Returns the value corresponding to this entry.  If the mapping
           * has been removed from the backing map (by the iterator's
           * {@code remove} operation), the results of this call are undefined.
           *
           * @return the value corresponding to this entry
           * @throws IllegalStateException implementations may, but are not
           *         required to, throw this exception if the entry has been
           *         removed from the backing map.
           */
          V getValue();

          /**
           * Replaces the value corresponding to this entry with the specified
           * value (optional operation).  (Writes through to the map.)  The
           * behavior of this call is undefined if the mapping has already been
           * removed from the map (by the iterator's {@code remove} operation).
           *
           * @param value new value to be stored in this entry
           * @return old value corresponding to the entry
           * @throws UnsupportedOperationException if the {@code put} operation
           *         is not supported by the backing map
           * @throws ClassCastException if the class of the specified value
           *         prevents it from being stored in the backing map
           * @throws NullPointerException if the backing map does not permit
           *         null values, and the specified value is null
           * @throws IllegalArgumentException if some property of this value
           *         prevents it from being stored in the backing map
           * @throws IllegalStateException implementations may, but are not
           *         required to, throw this exception if the entry has been
           *         removed from the backing map.
           */
          V setValue(V value);

          /**
           * Compares the specified object with this entry for equality.
           * Returns {@code true} if the given object is also a map entry and
           * the two entries represent the same mapping.  More formally, two
           * entries {@code e1} and {@code e2} represent the same mapping
           * if<pre>
           *     (e1.getKey()==null ?
           *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
           *     (e1.getValue()==null ?
           *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
           * </pre>
           * This ensures that the {@code equals} method works properly across
           * different implementations of the {@code Map.Entry} interface.
           *
           * @param o object to be compared for equality with this map entry
           * @return {@code true} if the specified object is equal to this map
           *         entry
           */
          boolean equals(Object o);

          /**
           * Returns the hash code value for this map entry.  The hash code
           * of a map entry {@code e} is defined to be: <pre>
           *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
           *     (e.getValue()==null ? 0 : e.getValue().hashCode())
           * </pre>
           * This ensures that {@code e1.equals(e2)} implies that
           * {@code e1.hashCode()==e2.hashCode()} for any two Entries
           * {@code e1} and {@code e2}, as required by the general
           * contract of {@code Object.hashCode}.
           *
           * @return the hash code value for this map entry
           * @see Object#hashCode()
           * @see Object#equals(Object)
           * @see #equals(Object)
           */
          int hashCode();

     }
}
