<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Campaign Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-4">
        <div class="row mb-4">
            <div class="col">
                <h1>Campaign Dashboard</h1>
            </div>
            <div class="col text-end">
                <a th:href="@{/messages/create}" class="btn btn-primary">Create New Campaign</a>
            </div>
        </div>

        <div class="card">
            <div class="card-header">
                <h5 class="card-title mb-0">Recent Campaigns</h5>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Campaign Name</th>
                                <th>Audience Segment</th>
                                <th>Created Date</th>
                                <th>Message</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr th:each="campaign : ${campaigns}">
                                <td th:text="${campaign.name}">Campaign Name</td>
                                <td th:text="${campaign.audienceSegmentName}">Segment</td>
                                <td th:text="${#temporals.format(campaign.createdAt, 'dd-MM-yyyy HH:mm')}">Date</td>
                                <td th:text="${#strings.abbreviate(campaign.message, 50)}">Message</td>
                                <td>
                                    <a th:href="@{/messages/view/{id}(id=${campaign.id})}" class="btn btn-sm btn-info">View Details</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
