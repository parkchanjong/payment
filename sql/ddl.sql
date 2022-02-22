create TABLE member (
        member_id integer NOT NULL auto_increment,
        name varchar(255) not null,
        created_date timestamp,
        last_modified_date timestamp,
        PRIMARY KEY (member_id)
    );

create TABLE account (
        account_id integer NOT NULL auto_increment,
        member_id integer,
        balance_id integer,
        bank_account_number integer,
        bank_code varchar(255),
        bank_account_id integer,
        created_date timestamp,
        last_modified_date timestamp,
        PRIMARY KEY (account_id)
);

create TABLE balance (
        balance_id integer NOT NULL auto_increment,
        amount integer NOT NULL,
        created_date timestamp,
        last_modified_date timestamp,
        PRIMARY KEY (balance_id)
    );

create TABLE history (
        history_id integer NOT NULL auto_increment,
        account_id integer,
        dtype varchar(31) not null,
        amount integer NOT NULL,
        bank_account_number integer,
        bank_code varchar(255),
        transation_balance integer NOT NULL,
        bank_tx_id integer,
        sucess_flag boolean NOT NULL,
        tx_id integer,
        created_date timestamp,
        last_modified_date timestamp,
        PRIMARY KEY (history_id)
    );

ALTER TABLE account
ADD FOREIGN KEY (member_id) REFERENCES member(member_id);

ALTER TABLE account
ADD FOREIGN KEY (balance_id) REFERENCES balance(balance_id);

ALTER TABLE history
ADD FOREIGN KEY (account_id) REFERENCES account(account_id);
