/**
 *    Copyright 2009-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * @author Clinton Begin
 */
public enum TransactionIsolationLevel {
  NONE(Connection.TRANSACTION_NONE),
  /**
   * 读未提交，一个事务能读取到另一个事务还未提交的数据，这个叫读未提交，这种事务隔离级别可能产生脏读
   * 因为如果另一个事务将数据回，滚，那么第一个事务读取的数据就是脏数据，数据库最终并没有这条数据，这种方式几乎不用
   * Oracle,默认是此级别
   */
  READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
  /**
   * 读已提交，一个事务提交的数据在另一个事务中才能读取到，没有提交则读取不到，可以预防脏读，
   * 但是会带来另一个问题，那就是“不可重复读”，也叫原始读取不可重复，什么意思：就是在同一个事务中，
   * 每次读取数据库，读取到的数据条数都不一致，因为有别的事务在提交事务。
   */
  READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
  /**
   * 可重复读，一个事务提交的数据，在另一个事务中依然也读取不到，也就是一个事务在开始读取数据时就做了标记一样，
   * 只能读取当此刻的数据，后面数据库发生的变化，这个读取事务是无法感知的，是读不到的，那么这样也有一个问题，那就是幻读，
   * 读取到的数据与数据库真实的数据不一致，产生了幻像：
   * MySOL默认是此级别
   */
  REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
  /**
   * 串行化，一个事务在操作事务的时候会把该表锁住，其他事物只能等待，这种级别可以解决上面的幻读，但是这种方式效率极低，
   */
  SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

  private final int level;

  TransactionIsolationLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
