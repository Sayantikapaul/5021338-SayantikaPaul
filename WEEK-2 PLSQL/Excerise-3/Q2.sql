create or replace procedure updateemployeebonus (
	p_department    in VARCHAR2,
	p_bonuspercentage in number
) is
    -- Variables to hold employee details
	v_employeeid employees.employeeid%type;
	v_salary     employees.salary%type;

    -- Cursor to fetch employees in the specified department
	cursor emp_cur is
	select employeeid,
	       salary
	  from employees
	 where department = p_department
	for update; -- Lock the rows for update to prevent concurrent changes

begin
    -- Open the cursor
	open emp_cur;

    -- Loop through each employee in the specified department
	loop
        -- Fetch the next row from the cursor into variables
		fetch emp_cur into
			v_employeeid,
			v_salary;

        -- Exit the loop if no more rows are found
		exit when emp_cur%notfound;

        -- Calculate the new salary by adding the bonus percentage
		v_salary := v_salary * ( 1 + p_bonuspercentage / 100 );

        -- Update the salary of the employee
		update employees
		   set salary = v_salary
		 where employeeid = v_employeeid;
	end loop;

    -- Commit the transaction
	commit;

    -- Close the cursor
	close emp_cur;
	dbms_output.put_line('Bonus updated successfully for employees in department '
	                     || p_department
	                     || '.');
exception
	when others then
        -- Handle any other exceptions
		dbms_output.put_line('Error during bonus update: ' || sqlerrm);
		rollback;
end updateemployeebonus;
/