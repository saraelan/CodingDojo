#1. What query would you run to get the total revenue for March of 2012?
SELECT MONTHNAME(charged_datetime) AS month, SUM(amount) AS revenue
FROM billing
WHERE MONTHNAME(charged_datetime) = "March" AND YEAR(charged_datetime) = "2012"
GROUP BY MONTHNAME(charged_datetime);

#What query would you run to get total revenue collected from the client with an id of 2?
SELECT client_id,SUM(amount) AS total_revenue FROM billing 
WHERE client_id=2;

# 3. What query would you run to get all the sites that client=10 owns?
SELECT domain_name ,client_id FROM sites WHERE client_id=10;

#4. What query would you run to get total # of sites created per month per year for the client with an id of 1? What about for client=20?
SELECT  client_id , COUNT(site_id) AS number_of_websites,MONTHNAME(created_datetime) AS mont_created,YEAR(created_datetime) AS year_created  FROM sites WHERE client_id=1 OR client_id=20 
GROUP BY MONTHNAME(created_datetime), YEAR(created_datetime);

#What query would you run to get the total # of leads generated for each of the sites between January 1, 2011 to February 15, 2011?

SELECT sites.domain_name AS website, COUNT(leads.leads_id) AS num_of_leads
, leads.registered_datetime AS date_generated
FROM sites
JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-02-15' GROUP BY sites.domain_name; 

#What query would you run to get a list of client names and the total # of leads we've generated for each of our clients 
#between January 1, 2011 to December 31, 2011?
SELECT CONCAT_WS(' ', clients.first_name, clients.last_name) AS client_name,
COUNT(leads.leads_id) AS number_of_leads
FROM clients
LEFT JOIN sites ON clients.client_id = sites.client_id
LEFT JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-12-31'
GROUP BY clients.client_id;

# 7. What query would you run to get a list of client name and the total # of 
#    leads we've generated for each client each month between month 1 - 6 of Year 2011?
SELECT CONCAT_WS(' ', clients.first_name, clients.last_name) AS client_name,
COUNT(leads.leads_id) AS number_of_leads, MONTHNAME(leads.registered_datetime) AS month_generated
FROM clients
LEFT JOIN sites ON clients.client_id = sites.client_id
LEFT JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-01' AND '2011-06-30'
GROUP BY clients.client_id, MONTHNAME(leads.registered_datetime)
ORDER BY leads.registered_datetime;

# 8. What query would you run to get a list of client name and the total # of 
#    leads we've generated for each of our client's sites between 
#    January 1, 2011 to December 31, 2011? 
SELECT CONCAT_WS(' ', clients.first_name, clients.last_name) AS client_name,
sites.domain_name AS website, COUNT(leads.leads_id) AS number_of_leads,
DATE_FORMAT(sites.created_datetime, '%M %d, %Y') AS date_generated
FROM clients
LEFT JOIN sites ON clients.client_id = sites.client_id
LEFT JOIN leads ON sites.site_id = leads.site_id
WHERE leads.registered_datetime BETWEEN '2011-01-1' AND '2011-12-31'
GROUP BY website
ORDER BY clients.client_id;

#    Come up with a second query that shows all the clients, 
#    the site name(s), and the total number of leads generated 
#    from each site for all time.
SELECT CONCAT_WS(' ', clients.first_name, clients.last_name) AS client_name,
sites.domain_name AS website, COUNT(leads.leads_id) AS number_of_leads
FROM clients
LEFT JOIN sites ON clients.client_id = sites.client_id
LEFT JOIN leads ON sites.site_id = leads.site_id
GROUP BY website ORDER BY clients.client_id, number_of_leads DESC;

# 9. Write a single query that retrieves total revenue collected 
#    from each client each month of the year.
SELECT CONCAT_WS(' ', clients.first_name, clients.last_name) AS client_name,
SUM(billing.amount) AS Tota_Revenue, MONTHNAME(billing.charged_datetime) AS month_charge,
YEAR(billing.charged_datetime) AS year_charge
FROM clients
LEFT JOIN billing ON clients.client_id = billing.client_id
GROUP BY client_name, month_charge, year_charge
ORDER BY clients.client_id, billing.charged_datetime;

# 10. Write a single query that retrieves all the sites that each client owns. 
#     Group the results so that each row shows a new client. 
#     Add a new field called 'sites' that has all the sites that the client owns. 
#     (HINT: use GROUP_CONCAT)
SELECT CONCAT_WS(' ', clients.first_name, clients.last_name) AS client_name,
GROUP_CONCAT(sites.domain_name SEPARATOR ' / ') AS sites
FROM clients
LEFT JOIN sites ON clients.client_id = sites.client_id
GROUP BY clients.client_id;




